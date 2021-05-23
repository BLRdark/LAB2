package controller.applicationController;

import controller.repository.StudentRepo;
import controller.service.StudentService;
import views.MainWindow;

public class Main {
    public static void main(String[] args) {
        StudentRepo professors = new StudentRepo();
        StudentService controller = new StudentService(professors);
        MainWindow indexWindow = new MainWindow(controller);
        indexWindow.show();
    }
}
