package info.jiaying.core;
public interface ObserverFunction {
    void onBoot();
    void onObtain();
    void onExecute();
    void onFinish();
    void onStop();
    void onError();
}
