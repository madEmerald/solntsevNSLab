package tech.reliab.course.solntsevns.controller.impl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.reliab.course.solntsevns.controller.BankAtmController;
import tech.reliab.course.solntsevns.entity.BankAtm;
import tech.reliab.course.solntsevns.model.BankAtmRequest;
import tech.reliab.course.solntsevns.service.BankAtmService;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/bank-atms")
public class BankAtmControllerImpl implements BankAtmController {
    private final BankAtmService bankAtmService;
    @Override
    @PostMapping
    public ResponseEntity<BankAtm> createBankAtm(BankAtmRequest bankAtmRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bankAtmService.createBankAtm(bankAtmRequest));
    }
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBankAtm(int id) {
        bankAtmService.deleteAtm(id);
        return ResponseEntity.noContent().build();
    }
    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<BankAtm> updateBankAtm(int id) {
        return ResponseEntity.ok(bankAtmService.updateAtm(id));
    }
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<BankAtm> getBankAtmById(int id) {
        return ResponseEntity.ok(bankAtmService.getAtm(id));
    }
    @Override
    @GetMapping("/all-by-bank/{bankId}")
    public ResponseEntity<List<BankAtm>> getAllBankAtmByBankId(int bankId) {
        return ResponseEntity.ok(bankAtmService.getAllBankAtmsByBankId(bankId));
    }
    @Override
    @GetMapping
    public ResponseEntity<List<BankAtm>> getAllBankAtms() {
        return ResponseEntity.ok(bankAtmService.getAllBankAtms());
    }
}