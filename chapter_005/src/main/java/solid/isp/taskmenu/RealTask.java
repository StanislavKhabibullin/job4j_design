package solid.isp.taskmenu;

public class RealTask implements Task {
    private String number;
    private String info;

    public RealTask(String number, String info) {
        this.number = number;
        this.info = info;
    }

    @Override
    public String taskNumber() {
        return number;
    }

    @Override
    public String internalInfo() {
        return info;
    }
}
