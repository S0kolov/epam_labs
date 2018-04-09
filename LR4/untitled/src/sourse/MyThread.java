package sourse;

public class MyThread extends Thread {

    private volatile boolean finish;
    private String string;

    private int counter = 0;

    private static final int limit = 50;

    public MyThread(String _string){
        setString(_string);
        finish=false;
    }

    @Override
    public void run(){
        while (true){
            if(!finish){
                if(counter!=50){
                    print();
                }else{
                    MainThread.pleaseStopMe(this);
                }
            }else {break;}
        }
    }

    public void setFinish(boolean _finish){
        finish=_finish;
    }
    private void print(){
        for(int i = 0;i<string.length();i++){
            System.out.print(string.charAt(i));
        }
        System.out.print("\n");
        counter++;
    }

    public void setString(String _string){
        string=_string;
        counter = 0;
    }
}
