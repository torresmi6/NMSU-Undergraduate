create table teams (
		TeamID			int not null,
        TeamName		varchar(32),
        City			varchar(32),
        primary key (TeamID));
        
create table players (
		PlayerID		int not null,
        FirstName		varchar(32),
        LastName		varchar(32),
        TeamID			int not null,
        Position		varchar(2) not null,
        Touchdowns		int,
        TotalYards		int,
        Salary			int,
        check (Position in ('QB', 'RB', 'WR')),
        primary key (PlayerID));


create table games (
		GameID			int not null,
        Date			date,
        Stadium			varchar(32),
        Result			varchar(1) not null,
        Attendance		int,
        TicketRevenue	int,
        check (Result in ('W', 'L', 'T')),
        primary key (GameID));
        

create table play (
		PlayerID		int not null,
        GameID			int not null,
        primary key (PlayerID),
        foreign key (PlayerID) references players (PlayerID),
        foreign key (GameID) references games (GameID));