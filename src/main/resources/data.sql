create table client(
    Id int identity(1, 1) primary key,
    Name varchar(250),
    Dni varchar(50),
    BirthDate date
)

create table service_payment(
    Id int identity(1,1) primary key,
    Name varchar(250),
    Channel varchar(50),
    CreationDate datetime,
    Status varchar(50)
)

create table service_payment_history(
    Id int identity(1,1) primary key,
    ClientId int,
    ServicePaymentId int,
    ServicePaymentName varchar(250),
    SupplyNumber varchar(250),
    Amount numeric,
    Currency varchar(250),
    TransactionDate datetime
)

insert into [dbo].[client](Name, Dni, BirthDate)
values('George Kelvin Castillo Farfan', '70291259', '1994-04-17'),
      ('Johnny Depp', '70291260', '1994-04-18'),
      ('Amber Heard', '70291261', '1994-04-19')

insert into [dbo].[service_payment](Name, Channel, CreationDate, Status)
values('MOVISTAR', 'BM', '2022-04-01', 'Activo'),
      ('MOVISTAR', 'BI', '2022-04-01', 'Activo'),
      ('CLARO', 'BM', '2022-04-01', 'Activo'),
      ('CLARO', 'BI', '2022-04-01', 'Activo'),
      ('ENTEL', 'BM', '2022-04-01', 'Activo'),
      ('ENTEL', 'BI', '2022-04-01', 'Activo'),
      ('SUNAT', 'BI', '2022-04-01', 'Activo'),
      ('RENIEC', 'BI', '2022-04-01', 'Activo'),
      ('TC CMR', 'BM', '2022-04-01', 'Activo'),
      ('TC CMR', 'BI', '2022-04-01', 'Activo'),
      ('TC INTERBANK', 'BM', '2022-04-01', 'Activo'),
      ('TC INTERBANK', 'BI', '2022-04-01', 'Activo')

