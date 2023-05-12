package com.example.demo.conroller;

import com.example.demo.Response.ResponseHandler;
import com.example.demo.model.RestModel;
import com.example.demo.repository.UserRepo;
import com.example.demo.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    @Autowired
    private Service service;
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/add")
    public RestModel add(@RequestBody RestModel restmodel){
        return service.addMethod(restmodel);

    }
    @GetMapping("/all")
    public List<RestModel> findall(){
        return service.getAllData();
    }
    @GetMapping("/find/{id}")
    public RestModel findbyid(@PathVariable Integer id)
    //public ResponseEntity<Object> findbyid(@PathVariable Integer id)
    {
       //return ResponseHandler.responseBuilder("Requested User Details are given here", HttpStatus.OK , service.findid(id));
        return service.findid(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deletebyid(@PathVariable Integer id){
         service.delete(id);

    }
@PutMapping("/update/{id}")
    public RestModel update(@PathVariable Integer id,@RequestBody RestModel restModel){
        return  service.update(id,restModel);
    }
////nativequery api
//    @GetMapping("/genderfind")
//    public List<Object> getGender(RestModel restModel) {
//     return userRepo.getCountGender();
//    }
//
////new
//    @GetMapping("/getisp")
//    public List<Object> getisp(RestModel restModel) {
//        return userRepo.getisp();
//    }
//
//    @GetMapping("/getagegroup")
//    public List<Object> getagegroup(RestModel restModel) {return userRepo.getagecategory();}
//
//    @GetMapping("/getagerange")
//    public List<Object> getagerange(RestModel restModel) {
//        return userRepo. getagerange();
//    }


    @GetMapping("/search")
    public ResponseEntity<List<RestModel>> searchUsers(
           @RequestParam(name = "full_name", required = false) String full_name ,
           @RequestParam(name = "nic_number", required = false) String nic_number)
//            ,
//           @RequestParam(name = "address", required = false) String address,
//           @RequestParam(name = "nationality", required = false) String nationality,
//           @RequestParam(name = "phone_number", required = false) String phone_number,
//           @RequestParam(name = "age", required = false) long age,
//           @RequestParam(name = "birth_day", required = false) String birth_day,
//           @RequestParam(name = "gender", required = false) String gender)
    {

    {

      //  List<RestModel> filteredUsers = userRepo.searchUsers(name,nic_number,userAddress,nationality,userMobile,birth_day,gender);
        List<RestModel> filteredUsers = userRepo.searchUsers(full_name,nic_number);
      //  ,address,nationality,phone_number,age,birth_day,gender
        if (filteredUsers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(filteredUsers, HttpStatus.OK);
        }
    }

}
}
