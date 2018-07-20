package taskManagement.commands;

public interface UserCommand {
    int LOGOUT=0;
int  PrintMyNewTasks=1;
int PrintMyCurrentTasks=2;
int PrintMyFinishedTasks=3;
int ChangeMyTaskStatusByName=4;
int ChangeMyTaskEstimationsByName=5;
int AddComments=6;
}
