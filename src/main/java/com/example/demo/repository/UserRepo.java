package com.example.demo.repository;

import com.example.demo.model.RestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<RestModel,Integer> {
//    @Query(value = "SELECT gender, COUNT(*) as count\n"
//            + "FROM `nic`.uesrnic \n"
//            + "GROUP BY gender",nativeQuery = true)
//    List<Object> getCountGender();
//
//        @Query(value="SELECT \n"
//                + "    CASE\n"
//                + "        WHEN phone_number LIKE '078%' THEN 'Hutch'\n"
//                + "        WHEN phone_number LIKE '071%' THEN 'Mobitel'\n"
//                + "        WHEN phone_number LIKE '070%' THEN 'Mobitel'\n"
//                + "        WHEN phone_number LIKE '076%' THEN 'Dialog'\n"
//                + "        WHEN phone_number LIKE '077%' THEN 'Dialog'\n"
//                + "        WHEN phone_number LIKE '072%' THEN 'Hutch'\n"
//                + "        WHEN phone_number LIKE '075%' THEN 'Airtel'\n"
//                + "        ELSE 'Unknown'\n"
//                + "    END AS category, \n"
//                + "    COUNT(*) AS count\n"
//                + "FROM `nic`.uesrnic \n"
//                + "GROUP BY category" ,nativeQuery = true)
//         List<Object> getisp();
//
//
//   @Query(value= "SELECT \n"
//            + "  CASE\n"
//            + "    WHEN age BETWEEN 0 AND 18 THEN '0-18'\n"
//            + "    WHEN age BETWEEN 19 AND 30 THEN '19-30'\n"
//            + "    WHEN age BETWEEN 31 AND 50 THEN '31-50'\n"
//            + "    WHEN age > 50 THEN '51+'\n"
//            + "  END AS age_category,\n"
//            + "  COUNT(*) AS count\n"
//            + "FROM `nic`.uesrnic\n"
//            + "GROUP BY age_category",nativeQuery = true)
//   List<Object> getagecategory();
//
//
//  @Query(value=  "SELECT \n"
//            + "    CONCAT(\n"
//            + "        FLOOR(EXTRACT(YEAR FROM birth_day) / 10) * 10, \n"
//            + "        '-', \n"
//            + "        FLOOR(EXTRACT(YEAR FROM birth_day) / 10) * 10 + 9\n"
//            + "    ) AS age_range, \n"
//            + "    COUNT(*) AS count\n"
//            + "FROM `nic`.uesrnic\n"
//            + "GROUP BY age_range\n"
//            + "ORDER BY age_range ASC",nativeQuery = true)
//          List<Object> getagerange();
//
//   @Query(value="SELECT \n"
//            + "  CASE \n"
//            + "    WHEN nic_number >= '2020-01-01' THEN 'New NIC Range' \n"
//            + "    ELSE 'Old NIC Range' \n"
//            + "  END AS `NIC Range`, \n"
//            + "  COUNT(*) AS `NIC Count` \n"
//            + "FROM \n"
//            + "  `nic`.uesrnic\n"
//            + "GROUP BY \n"
//            +"`NIC Range`",nativeQuery = true)
//   List<Object> getnicrange();
//@Query("SELECT u FROM nic u WHERE " +
//// "(:userId IS NULL OR u.userId = :userId) AND "+
//        "(:full_name IS NULL OR u.full_name = :full_name) AND "+
//        "(:nic_number IS NULL OR u.nic_number = :nic_number) AND "+
//        "(:address IS NULL OR u.address = :address) AND "+
//        "(:nationality IS NULL OR u.nationality = :nationality) AND "+
//        "(:phone_number IS NULL OR u.phone_number = :phone_number) AND "+
//        "(:age IS NULL OR u.age = :age) AND "+
//        "(:birth_day IS NULL OR u.birth_day = :birth_day) AND "+
//        "(:gender IS NULL OR u.gender = :genedr)")
////"u.userRole = ?1 and u.full_name LIKE %?2%"
//List<RestModel> userMainSearch(@Param("full_name") String full_name, @Param("nic_number") int nic_number,
//                          @Param("userAddress") String userAddress,@Param("nationality") String nationality,
//                          @Param("phone_number") String userMobile,@Param("age") long age,
//                            @Param("birth_day") String birth_day, @Param("gender") String gender);


    @Query (value="SELECT * FROM uesrnic  WHERE " +
            "(:full_name IS NULL OR full_name = :full_name) AND " +
            "(:nic_number IS NULL OR nic_number = :nic_number)",nativeQuery = true)
            //+
//            "(:address IS NULL OR Address = :address) AND "+
//            "(:nationality IS NULL OR nationality = :nationality) AND "+
//             "(:phone_number IS NULL OR phone_number = :phone_number) AND "+
//            "(:age IS NULL OR age = :age) AND "+
//             "(:birth_day IS NULL OR birth_day = :birth_day) AND "+
//            "(:gender IS NULL OR gender = :genedr)",nativeQuery = true)
    List<RestModel> searchUsers(
            @Param("full_name") String full_name,
            @Param("nic_number") String nic_number);
            //,
//            @Param("address") String address,
//            @Param("nationality") String nationality,
//            @Param("phone_number") String phone_number,
//            @Param("age") long age,
//            @Param("birth_day") String birth_day,
//            @Param("gender") String gender);


}
