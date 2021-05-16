pico-8 cartridge // http://www.pico-8.com
version 29
__lua__
-------------------------------
----- init function -----------
-------------------------------

-- global variables

-- canvas tile size
f_size = 16

-- rooms to draw
room_max = 1

-- test camera
camx = 0
camy = 0
camera(camx, camy)

-- four studios logo
function startup()
 cls()
 rectfill(47, 60, 52, 65, 11)
 rectfill(47, 64, 48, 65, 0)
 delay(5)
 rectfill(47, 52, 52, 57, 11)
 rectfill(47, 52, 48, 53, 0)
 delay(5)
 rectfill(55, 52, 60, 57, 11)
 rectfill(59, 52, 60, 53, 0)
 delay(5)
 rectfill(55, 60, 60, 65, 11)
 rectfill(59, 64, 60, 65, 0)
 delay(5)
 rectfill(53, 58, 54, 59,11)

 delay(10)
 color(7)
 print("four", 63, 54)
 delay(10)
 color(6)
 print("studios", 63, 60)
 
 delay(30)
 cls()
   
end

function delay(t)
 for i=0, t do
  flip()
 end
end


function _init()
 -- intro logo
  startup()
 
 camx = -64
 camy = -64
 -- initial floorgen
 floorgen()
 
end
-->8
 -------------------------------
----------- update  -----------
-------------------------------
-- note: function update every
-- 60 fps

function _update60()
 
 -- buttons for gen testing
 -- and simple camera movement
 -- !!only for testing!!
 if(btnp(🅾️,0)) then
  if(room_max < #floor) then
   room_max += 1
   opn_door()
  end
 end
 if(btnp(❎,0)) then
  room_max = 1
  floorgen()
 end
 if(btn(⬆️,0)) then
  camy -= 1
 end
 if(btn(⬇️,0)) then
  camy += 1
 end
 if(btn(➡️,0)) then
  camx += 1
 end
 if(btn(⬅️,0)) then
  camx -= 1
 end
 camera(camx, camy)
end
-->8
-------------------------------
------------ draw -------------
-------------------------------

-- draw flattened matrix
function draw_room(matx, x, y) 
 j = 0
 i = 0
 for k=1, #matx.r do
  -- if top layer, draw opaque
  if(matx.r[k] == 1 or
     matx.r[k] == 2 or
     matx.r[k] == 3 or
     matx.r[k] == 7) then
   palt(0, false)
  end
  
  -- draw room objects
  spr(matx.o[k], x+i*8, y+j*8)
  
  -- draw room tiles 
  spr(matx.r[k], x+i*8, y+j*8)
  
  -- reset draw transparency
  palt()
 
  -- loop variables
  i += 1
  if(i%matx.w == 0) then
   j += 1
   i = 0
  end
 end
 
end

function draw_floor()
 for i=room_max, 1, -1 do 
  draw_room(floor[i],
         floor.coord_x[i], 
         floor.coord_y[i])
  --print(floor.coord_x[i]/8)
  --print(floor.coord_y[i]/8)
 end
end

function _draw()
 cls()
 -- print room var's
 --printhelp()
 
 -- change palette
 -- use 1 on 3rd param for
 -- extended color palette 
 -- pal(0, 134, 1)
 
 -- testing help
 print("~~testing controls~~",
       -32, 8)
 print("press x for new floor",
       -32, 16)
 print("press z for next room",
       -32, 24)
 print("⬅️ ⬆️ ⬇️ ➡️ for camera",
       -32, 32)
  
 -- draw floor
 draw_floor()
end

function printhelp()
 print("w & h")
 print(room.w)
 print(room.h)
 print("tile")
 print(room.tp)
 print("row")
 print(room.cr)
 print("size")
 print(#room.r)
 print("tp dr")
 print(room.tpdr)
 print("bt dr")
 print(room.btdr)
 print("lcrn")
 print(room.lcrn)
end

-- door open, make to
-- have more flare!
function opn_door()
 floor[room_max-1].r[floor[room_max-1].tpdr+1] = 0
end
-->8
-------------------------------
------- full floor gen --------
-------------------------------

function floorgen()

 -- floor collection
 floor = {}
 local floornum = 5
 floor.coord_x = {}
 floor.coord_y = {}
 
 -- generate and set rooms
 for i=1, floornum do 
  roomgen()
  floor[i] = room
 end
 
 -- determine door placement
 local strt_x = 0
 local strt_y = -8
 for i=1, floornum do 
  -- set start position
  strt_x -= (floor[i].btdr*8) 
  strt_y -= (floor[i].h-1)*8
  -- set point
  add(floor.coord_x, strt_x)
  add(floor.coord_y, strt_y)  
  -- update start position
  strt_x += floor[i].tpdr*8
  
  -- old operations (keep for
  -- reference)
  --strt_x=strt_x+(floor[i].tpdr*8-floor[i].btdr*8) 
  --strt_y=strt_y-(floor[i].h-1)*8 
 end
 
 -- remove bottom door
 -- from first room in floor
 for i=1, #floor[1].r do 
  if(floor[1].r[i] == 18) then
   floor[1].r[i] = 12
   floor[1].r[i-floor[1].w] = 5
  end
 end
 
end -- floorgen()

-->8
-------------------------------
-------- full room gen --------
-------------------------------

function roomgen()
 -- gen floor
 room = {}
 
 -- room tiles
 room.r = {flr(rnd(2))}
 
 -- variables for insuring
 -- door placements and setting
 -- room "divits" for complexity
 -- complexit is 2 max for gen
 -- reasons
 room.comp = 2
 room.drf = false
 
 -- variable for figuring out
 -- divit start
 room.lcrn = 0
 
 -- variables for storing top
 -- and bottom door offsets
 room.tpdr = 0
 room.btdr = 0
 
 -- det. top layer
 topnxt(room)
 
 -- set room width and height
 -- based on top layer gen with
 -- minumum of 5 height
 room.w = #room.r
 --room.h = (flr(rnd(room.w/2)+5))
 room.h = 10
 
 -- det. rest of room
 for i=2, room.h do
  room.drf = false --door plcmt
  room.tp = 0  -- tiles placed
  room.cr = i  -- current row
  nxt(room) 
 end
 
 -- room objects
 roomfill()
 room.o = obj
 
end

-->8
-------------------------------
----- top room layer gen  -----
-------------------------------

function topnxt(f)
 -- prev tile
 local prev = f.r[#f.r]
 
 -- base case
 if(f.comp == 0) then
  return
 end
 
 -- randomizer variable
 local ch = flr(rnd(2))
 
 -- recurse case to det. next
 -- no tile
 if(prev == 0) then
  if(ch == 0) then
   add(f.r, 0)
  end
  add(f.r, 1)
   f.lcrn = #f.r
  return topnxt(f)
 -- left corner tile
 elseif(prev == 1) then
  -- insure door
  if((ch == 0 or 
      f.comp == 1) and
      f.drf == false) then
   add(f.r, 7)
   -- set top door offset
   f.tpdr = #f.r-1
  else
   add(f.r, 2)
  end
  return topnxt(f)
 -- wall tile
 elseif(prev == 2) then
  -- bigger rooms
  -- remove to shrink rooms
  local ch2 = flr(rnd(2))
  if(ch2 == 0) then
   add(f.r, 2)
  end
  -- remove to here
  if(ch == 0 and
     f.drf == false) then
   add(f.r, 7)
   -- set top door offset
   f.tpdr = #f.r-1 
  else
   add(f.r, 3)
  end
  return topnxt(f)
 -- door tile
 elseif(prev == 7) then
  f.drf = true
  if(ch == 0) then
   add(f.r, 2)
  else
   add(f.r, 3)
  end
  return topnxt(f)
 -- right corner tile
 elseif(prev == 3) then
  f.comp -= 1
  add(f.r, 0)
  return topnxt(f)
 end
end -- topnxt()

-->8
-------------------------------
------- room layers gen -------
-------------------------------
-- note: potential to reduce 
-- token count if need be

function nxt(f)
 -- previous tile, above tile
 -- above-1 tile, above+1 tile
 -- and current tile
 local abov =(f.r[(#f.r-f.w)+1])
 local prev =f.r[#f.r]
 local tpr =(f.r[(#f.r-f.w)+2])
 local tpl =(f.r[#f.r-f.w])
 local pos =((#f.r+1) % f.w)
 
 -- set prev and above-1 to 
 -- 0 if first in line
 if(#f.r % f.w == 0) then
  prev = 0
  tpl = 0
 end

 -- base case
 if(f.tp == f.w) then
  return
 end
 
 -- increment tiles placed
 f.tp+=1
 
 -- recurse cases to det. next
 -- based on tile above, 
 -- topleft, topright, and
 -- previous
 
 -- randomizer variable
 local ch = flr(rnd(2))
 
 -- production rules
 -- no tile
 if(abov == 0) then
  if(prev == 0 or
     prev == 3 or
     prev == 6 or
     prev == 10 or
     prev == 13) then
   if(pos == 0 or
      pos >= f.lcrn or
      f.cr >= f.h-2) then
    add(f.r, 0)
   elseif(pos == 1 or
        ch == 0 or 
        tpr == 8
        ) then
    add(f.r, 1)
   else
    add(f.r, 0)
   end
  elseif(prev == 1 and
         pos == 0) then
    add(f.r, 3)
  elseif(prev == 2 or
         prev == 15) then
   if(pos == 0 or
      pos >= f.lcrn or
      f.cr == 1) then
    add(f.r, 3)
   else
    add(f.r, 2)
   end
  else
    add(f.r, 2)
  end
  return nxt(f)
  
 -- upper left corner
 elseif(abov == 1) then
  if(prev == 1 or
     prev == 2 or
     prev == 15) then
   add(f.r, 14)
  elseif(f.cr >= f.h-1) then
   add(f.r, 4)
  else
   add(f.r, 8)
  end
  return nxt(f)
  
 -- wall or door tiles
 elseif(abov == 2 or
        abov == 7) then
   if(prev == 4 or
      prev == 5) then
    if(f.cr >= f.h-1 or
       pos >= f.w-2) then
     add(f.r, 5)
    elseif(tpr == 14) then
     add(f.r, 16)
    elseif(ch == 0) then
     add(f.r, 5)
    else
     add(f.r, 16)
    end
  else
   add(f.r, 9)
  end
  return nxt(f)
  
 -- upper right corner tile
 elseif(abov == 3) then
  -- helper for door rand
  if(f.cr == f.h-1) then
   f.comp += 1
  end 
  if(prev == 8 or
     prev == 9 or
     prev == 14 or
     prev == 15 or
     prev == 16) then
   if(pos == 0) then
    add(f.r, 10)
   else
    add(f.r, 15)
   end
  else
    add(f.r, 6)
  end
  return nxt(f)
  
 -- lower left corner tile 
 elseif(abov == 4) then
  if(prev == 1 or
     prev == 2 or
     prev == 15) then
   add(f.r, 2)
  elseif(prev == 6) then
   if(ch == 0 and
      f.cr < f.h-1) then
    add(f.r, 1)
   else
    add(f.r, 11)
   end  
  else
   add(f.r, 11)
  end
  return nxt(f)
  
 -- bottom wall tile 
 elseif(abov == 5) then
  if(prev == 1 or
     prev == 2) then
   if(ch == 0) then
    add(f.r, 2)
   else
    add(f.r, 3)
   end
  elseif(prev == 5 and
         tpr == 6) then
   add(f.r, 6)
  elseif(prev == 15) then
   add(f.r, 2)
  elseif(prev == 11 or
         prev == 12 or
         prev == 18) then
   -- revise code for door!!
   -- insure bottom door
   if(f.cr == f.h) then
    if(tpr == 6) then
     if(f.comp == 1 and
        f.drf == false) then
      f.drf = true
      add(f.r, 18)
      -- adjust tile above door
      -- (might move to open
      -- door animation func)
      f.r[#f.r-f.w] = 9
      -- set bottom door offset
      f.btdr = f.tp-1
     else
      f.comp -= 1
      add(f.r, 12)
     end
    elseif(ch == 0 and
       f.drf == false) then
     f.drf = true
     add(f.r, 18)
     -- adjust tile above door
     -- (might move to open
     -- door animation func)
     f.r[#f.r-f.w] = 9
     -- set bottom door offset
     f.btdr = f.tp-1
    else
     add(f.r, 12)
    end
   else
    add(f.r, 12)
   end
   -- end revision area
  else  
   add(f.r, 12)
  end
  return nxt(f)
  
 -- lower right corner tile 
 elseif(abov == 6) then
  if(prev == 2) then
   if(pos == 0 or
      ch == 0 or
     (tpr != 0 and
      f.cr < f.h -3)) then
    add(f.r, 3)
   else
    add(f.r, 2)
   end
  elseif(prev == 15) then
   if(pos == 0) then
    add(f.r, 3)
   else 
    add(f.r, 2)
   end
  else
   add(f.r, 13)
  end
  return nxt(f)
  
 -- left wall tile
 elseif(abov == 8) then
  if(prev == 0 or
     prev == 3 or
     prev == 6 or
     prev == 10 or
     prev == 13) then 
   if(f.cr >= f.h-1) then
    add(f.r, 4)
   elseif(pos >= f.lcrn) then
    add(f.r, 8)
   elseif(ch == 0 and
      pos <= f.w-3) then
    add(f.r, 4)
   else
    add(f.r, 8)
   end
  else
   add(f.r, 14)
  end
  return nxt(f)
  
 -- ground tile
 elseif(abov == 9) then
  if(prev == 4) then
   if(f.cr >= f.h-1 or
     pos >= f.w-2) then
    add(f.r, 5)
   elseif(tpr == 6) then
    add(f.r, 6)
   else
    add(f.r, 16)
   end
  elseif(prev == 5 or
         prev == 17) then
   if(ch == 0 or
      f.cr >= f.h-1) then
    add(f.r, 5)
   elseif(pos >= f.w-2) then
    add(f.r, 5)
   else
    add(f.r, 16)
   end  
  elseif(prev == 9) then
   if(ch == 0) then
    add(f.r, 17)
   else
    add(f.r, 9)
   end
  elseif(prev == 11 or
         prev == 12) then
   add(f.r, 8)
  else
   add(f.r, 9)
  end
  return nxt(f)
  
 -- right wall tile
 elseif(abov == 10) then
  -- helper for door rand
  if(f.cr == f.h-1 and
     prev == 5) then
   f.comp += 1
  end 
  if(prev == 8 or
     prev == 9 or
     prev == 14 or
     prev == 16) then
   if(pos == 0) then
    add(f.r, 10)
   else
    add(f.r, 15)
   end
  elseif(prev == 12) then
   add(f.r, 13)
  else
   add(f.r, 6)
  end
  return nxt(f)
  
 -- outside left corner tile 
 elseif(abov == 11 or
        abov == 12) then
  if(prev == 1 or
     prev == 2 or
     prev == 15) then
   if(ch == 0 or
      pos <= f.lcrn) then
    add(f.r, 2)
   elseif(ch == 1 and
         abov == 12) then
    add(f.r, 3)
   end
  else
   add(f.r, 0)
  end
  return nxt(f)
  
 -- outside right corner tile 
 elseif(abov == 13) then
  if(prev == 0 or
     prev == 3 or
     prev == 6 or
     prev == 10 or
     prev == 13) then
   if(pos >= f.lcrn) then
    add(f.r, 0)
   elseif(tpr == 8 and
      f.cr <= f.h-2 and
      pos != 0) then
    add(f.r, 1)
   elseif(ch == 0 or
          pos == 0 or
          f.cr >= f.h-3) then
    add(f.r, 0)
   else
    add(f.r, 1)
   end 
  elseif(prev == 2 or
         prev == 9) then
   if(pos == 0 or 
      f.cr >= f.h-2) then
    add(f.r, 3)
   elseif(ch == 0) then
    add(f.r, 2)
   else
    add(f.r, 3)
   end
  elseif(prev == 15) then
   if(pos == 0) then
    add(f.r, 3)
   else
    add(f.r, 2)
   end
  end
  return nxt(f)
 
  -- inside left wall tile 
 elseif(abov == 14) then
  if(prev == 4 or
     prev == 5) then
   if(f.cr >= f.h-1) then
    add(f.r, 5)
   else
    add(f.r, 16)
   end
  else
   add(f.r, 9)
  end
  return nxt(f)
 
 -- inside right wall tile 
 elseif(abov == 15) then
  if(prev == 4 or 
     prev == 5 or
     prev == 17) then
   if(f.cr >= f.h-1) then
    add(f.r, 5)
   elseif(pos >= f.w-2) then
    add(f.r, 5)
   elseif((pos <= f.lcrn and
          prev == 4) or
          f.cr >= f.h-3) then
    add(f.r, 16)
   else
    add(f.r, 5)
   end
  else
   add(f.r, 9)
  end
  return nxt(f)
  
 -- inside left corner tile 
 elseif(abov == 16) then
  if(prev == 3 or
     prev == 6 or
     prev == 10 or
  			prev == 11 or
     prev == 12) then
   if(f.cr >= f.h-1) then
    add(f.r, 4)
   elseif(pos >= f.lcrn) then
    add(f.r, 8)
   elseif(ch == 0 and
          f.cr >= f.h/2) then
    add(f.r, 4)
   else
    add(f.r, 8)
   end
  else
   add(f.r, 14) 
  end
  return nxt(f)
  
 -- inside right corner tile 
 elseif(abov == 17) then
  -- helper for door rand
  if(f.cr == f.h-1) then
   f.comp += 1
  end
  if(prev == 5 or
     prev == 17) then
   add(f.r, 6)
  elseif(prev == 9) then
   if(pos >= f.lcrn) then
    add(f.r, 10)
   elseif(ch == 0 or
      f.cr >= f.h-2) then
    add(f.r, 15)
   else
    add(f.r, 10)
   end
  elseif(prev == 16) then
    add(f.r, 15)
  end
  return nxt(f)
  
 end
end -- nxt()

-->8
-------------------------------
----- room object fill gen ----
-------------------------------

function roomfill()
 -- parallel matrix, holding
 -- room entity objects

 -- objects collection
 obj = {}
 
 -- loop through room layout
 -- and add objects
 for i=1, #room.r do
  -- randomizer variable
  -- value in rand determines
  -- percentage. ex. 5 means
  -- 1/5 chance to spawn!!
  local ch = flr(rnd(7))
 
  -- if at a object valid
  -- tile, have a chance
  -- to place object
  if(i == #room.r-(room.w
             +(room.w
              -room.btdr-1)) or
     i == room.tpdr+room.w+1
    ) then
   add(obj, 0)
  elseif(ch == 0 and
        (room.r[i] == 4 or
         room.r[i] == 5 or
         room.r[i] == 6 or
         room.r[i] == 8 or
         room.r[i] == 9 or
         room.r[i] == 10 or
         room.r[i] == 14 or
         room.r[i] == 15)) then
   ch = flr(rnd(20))
   -- barrel: base 70% chance
   -- 16/20 
   if(ch < 16) then
    add(obj, 48)
   -- crate: base 25% chance
   -- 5/20 
   elseif(ch >= 16 and
          ch < 19) then
    add(obj, 49)
   -- chest: base 5% chance
   -- 1/20 
   else
    add(obj, 50)
   end
  else
   add(obj, 0)
  end
 end
 
end -- end roomfill()
__gfx__
00000000007777777777777777777500700000500500000005000075777777777000005005000000050000755050050000500050000005057500000505005077
00000000075005000500050005000750700000000000000000000075600000067000000000000000000000755050050000500000005000055000000000000050
00000000750005000500050005000575700000000000000000000075600000067000000000000000000000755000000500000005005000055000000000000050
00000000750005000500050005000575700000000000000000000075600000067000000000000050000000755000500500005005000000055000000000000050
00000000750005000500050005000575700000000000000050000075600006067000000000000000500000755000500000005000000500055000005000000050
00000000750005000500050005000575700000000000005000000075600000067000000000000000000000755000500005005000000500055000000050000050
00000000750005000500050005000575570000500000000000000755600000067000000000000000000000750500000005000000500000505000000000000050
00000000755555555555555555555575507777777777777777777505666666667005000000005000000050750055555555555555555555005050000000050055
05000005050000006500000600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
00000000000000506500000600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
00000000000000006500000600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
00000000000000006500000600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
00000050000000006500000600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
00000000000000006500000600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
00000000000000006500000600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
75005000000500776500000600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
00000000000000000000000060000600000000000000000000555500000000000055550000000000005555000000000000000000000000000000000000000000
00666000066666000066600005060506006666000000000005ffff5000555500055555500055550005ffff500055550000000000000000000000000000000000
060006000600060006000600006000600600006000000000053f3f5005ffff500555555005555550053ff35005ffff5000000000000000000000000000000000
06666600066666000660660006600000066066600000000005fff55a053f3f5005a559500555555005ffff50053ff35000000000000000000000000000000000
06000600060066000606060006006056060606000000000000555d1005fff51a015a951005a559500155551005ffff5000000000000000000000000000000000
060006000606060006000600005060600600060000000000001ddd1000555d1001d9ad10065aa51001d55d100155557000000000000000000000000000000000
006660000666660006666600060606000666660000000000006222600002262006922a6000922a00062222600022220000000000000000000000000000000000
00000000000000000000000060000050000000000000000000050500000055000050050000055000005005000005500000000000000000000000000000000000
