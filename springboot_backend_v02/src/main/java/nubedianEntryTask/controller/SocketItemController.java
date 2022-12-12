package nubedianEntryTask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nubedianEntryTask.model.SocketItem;
import nubedianEntryTask.repository.SocketItemRepository;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/cpus/")
public class SocketItemController {
	
	@Autowired
    private SocketItemRepository socketItemRep;

    @GetMapping("/socketlist")
    public List<SocketItem> getAllSocketItems(){
        return socketItemRep.findAll();
    }
}
