package tech.reliab.course.solntsevns.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import tech.reliab.course.solntsevns.entity.BankOffice;
import tech.reliab.course.solntsevns.model.BankOfficeRequest;
import java.util.List;
public interface BankOfficeController {
    ResponseEntity<BankOffice> createBankOffice(@RequestBody BankOfficeRequest bankOfficeRequest);
    ResponseEntity<Void> deleteBankOffice(@PathVariable int id);
    ResponseEntity<BankOffice> updateBankOffice(@PathVariable int id);
    ResponseEntity<BankOffice> getBankOfficeById(@PathVariable int id);
    ResponseEntity<List<BankOffice>> getAllBankOffices();
}