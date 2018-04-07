create database sapphire;
create user sapphire with PASSWORD 's@ph1r3user';
grant select, update, delete on all tables in schema public to sapphire;
grant execute on all functions in schema public to sapphire;