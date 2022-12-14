package TYS.RestService.rest;

import TYS.RestService.domain.Attendance;
import TYS.RestService.domain.StudentAttendance;
import TYS.RestService.dto.AttendanceCreateDTO;
import TYS.RestService.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attendances")
public class AttendanceController {

    AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/{id}")
    public Attendance getAttendance(@PathVariable int id){
        return attendanceService.getAttendance(id);
    }

    @GetMapping("/studentAttendances")
    public List<StudentAttendance> getStudentAttendance(){
        return attendanceService.getStudentAttendances();
    }

    @GetMapping("attendance/{id}")
    public List<StudentAttendance> getAttendanceById(@PathVariable int id) {
        return attendanceService.getAttendanceById(id);
    }

    @GetMapping("student/{studentId}")
    public List<StudentAttendance> getAttendanceByStudentId(@PathVariable int studentId) {
        return attendanceService.getAttendanceByStudentId(studentId);
    }

    @GetMapping
    public List<Attendance> getAttendances(){
        return attendanceService.getAttendances();
    }

    @PostMapping
    public void takeAttendance(@RequestBody AttendanceCreateDTO attendanceCreateDTO) throws NullPointerException {
         attendanceService.takeAttendance(attendanceCreateDTO);
    }

    @PutMapping("/{id}")
    public void updateAttendance(@PathVariable int id, @RequestBody AttendanceCreateDTO attendanceCreateDTO) {
         attendanceService.updateAttendance(id, attendanceCreateDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable int id) {
        attendanceService.deleteAttendance(id);
    }
}
