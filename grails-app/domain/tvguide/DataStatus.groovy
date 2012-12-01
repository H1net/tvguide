package tvguide

public enum DataStatus { 
    ACTIVE(1), DELETED(2)
    
    private final int idVal;
    
    DataStatus(int id) {
        this.idVal = id;
    }
    
    public int getId() {
        return idVal;
    }
} 