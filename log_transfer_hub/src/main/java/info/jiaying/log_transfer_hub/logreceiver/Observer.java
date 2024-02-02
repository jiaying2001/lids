package info.jiaying.log_transfer_hub.logreceiver;

public interface Observer {
    void ONRECEIVE(String logJson);
}
