package nubedianEntryTask.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cpulist")

public class CpuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "socketid")
    private Integer socketid;

    @Column(name = "clockspeed")
    private String clockspeed;

    @Column(name = "cores")
    private Integer cores;

    @Column(name = "threads")
    private Integer threads;
    
    @Column(name = "tdp")
    private Integer tdp;

    @Column(name = "price")
    private Float price;

    public CpuItem() {};
    
    public CpuItem(Integer id, String brand, String model, Integer socketid, String clockspeed, Integer cores, Integer threads, Integer tdp, Float price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.socketid = socketid;
        this.clockspeed = clockspeed;
        this.cores = cores;
        this.threads = threads;
        this.tdp = tdp;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSocketId() {
        return socketid;
    }

    public void setSocketId(Integer socketid) {
        this.socketid = socketid;
    }

    public String getClockSpeed() {
        return clockspeed;
    }

    public void setClockSpeed(String clockspeed) {
        this.clockspeed = clockspeed;
    }

    public Integer getCores() {
        return cores;
    }

    public void setCores(Integer cores) {
        this.cores = cores;
    }

    public Integer getThreads() {
        return threads;
    }

    public void setThreads(Integer threads) {
        this.threads = threads;
    }
    
    
    public Integer getTdp() {
		return tdp;
	}

	public void setTdp(Integer tdp) {
		this.tdp = tdp;
	}

	public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
