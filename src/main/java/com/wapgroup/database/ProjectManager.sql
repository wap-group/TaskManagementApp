/*CREATE DATABASE taskmanagerdb;*/
use taskmanagerdb;

CREATE TABLE IF NOT exists assigntask (
        taskId VARCHAR(25) NOT NULL,
        teamId VARCHAR(25),
        developerId VARCHAR(25) NOT NULL
);

CREATE TABLE IF NOT exists team (
        teamId VARCHAR(25) NOT NULL,
        teamName VARCHAR(25)
);

CREATE TABLE IF NOT exists assignteam (
        taskId VARCHAR(25),
        teamId VARCHAR(25) NOT NULL,
        developerId VARCHAR(25) NOT NULL
);