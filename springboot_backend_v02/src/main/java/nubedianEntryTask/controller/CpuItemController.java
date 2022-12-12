package nubedianEntryTask.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nubedianEntryTask.exception.ResourceNotFoundException;
import nubedianEntryTask.model.CpuItem;
import nubedianEntryTask.repository.CpuItemRepository;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/cpus/")
public class CpuItemController {

    @Autowired
    private CpuItemRepository cpuItemRep;

    @GetMapping("/cpulist")
    public List<CpuItem> getAllCpuItems(){
        return cpuItemRep.findAll();
    }

    @PostMapping("/cpulist")
    public CpuItem createCpuItem(@RequestBody CpuItem cpu){
        return cpuItemRep.save(cpu);
    }

    @GetMapping("/cpulist/{id}")
    public ResponseEntity<CpuItem> getCpuItemById(@PathVariable Integer id) {
        CpuItem cpu = cpuItemRep.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CPU does not exist with id:" + id));
        return ResponseEntity.ok(cpu);
    }

    @PutMapping("/cpulist/{id}")
    public ResponseEntity<CpuItem> updateCpuItem(@PathVariable Integer id, @RequestBody CpuItem cpuItemDetails){
        CpuItem cpu = cpuItemRep.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CPU does not exist with id :" + id));

        cpu.setId(cpuItemDetails.getId());
        cpu.setBrand(cpuItemDetails.getBrand());
        cpu.setModel(cpuItemDetails.getModel());
        cpu.setSocketId(cpuItemDetails.getSocketId());
        cpu.setClockSpeed(cpuItemDetails.getClockSpeed());
        cpu.setCores(cpuItemDetails.getCores());
        cpu.setThreads(cpuItemDetails.getThreads());
        cpu.setTdp(cpuItemDetails.getTdp());
        cpu.setPrice(cpuItemDetails.getPrice());

        CpuItem updatedCPU = cpuItemRep.save(cpu);
        return ResponseEntity.ok(updatedCPU);
    }

    @DeleteMapping("/cpulist/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCPU(@PathVariable Integer id) {
        CpuItem cpu = cpuItemRep.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CPU does not exist with id:" + id));
        cpuItemRep.delete(cpu);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
