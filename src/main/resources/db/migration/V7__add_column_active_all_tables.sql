ALTER TABLE accounts ADD COLUMN deleted boolean DEFAULT false;
ALTER TABLE features ADD COLUMN deleted boolean DEFAULT false;
ALTER TABLE phones   ADD COLUMN deleted boolean DEFAULT false;
ALTER TABLE profiles ADD COLUMN deleted boolean DEFAULT false;
ALTER TABLE users    ADD COLUMN deleted boolean DEFAULT false;
ALTER TABLE vault    ADD COLUMN deleted boolean DEFAULT false;

