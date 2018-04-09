package sourse;

public class MainThread {

    public static void main(String[] arg){
        String[] strings = {"Hello world","Goodby my friend"};


    }

    private void createThread(String message){
        Thread thread = new Thread(new MyThread(message));
        thread.start();
    }

    public static void pleaseStopMe(MyThread thread){
        thread.setFinish(true);
    }
}
