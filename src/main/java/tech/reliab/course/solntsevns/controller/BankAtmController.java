package tech.reliab.course.solntsevns.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import tech.reliab.course.solntsevns.entity.BankAtm;
import tech.reliab.course.solntsevns.model.BankAtmRequest;
import java.util.List;
public interface BankAtmController {
    ResponseEntity<BankAtm> createBankAtm(@RequestBody BankAtmRequest bankAtmRequest);
    ResponseEntity<Void> deleteBankAtm(@PathVariable int id);
    ResponseEntity<BankAtm> updateBankAtm(@PathVariable int id);
    ResponseEntity<BankAtm> getBankAtmById(@PathVariable int id);
    ResponseEntity<List<BankAtm>> getAllBankAtmByBankId(@PathVariable int bankId);
    ResponseEntity<List<BankAtm>> getAllBankAtms();
}