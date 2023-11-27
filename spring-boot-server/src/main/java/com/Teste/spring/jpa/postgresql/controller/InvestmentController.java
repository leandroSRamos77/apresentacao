package com.Teste.spring.jpa.postgresql.controller;
/*

@RestController
@RequestMapping("/api/investments")
public class InvestmentController {

    @Autowired
    private InvestmentService investmentService;

    @GetMapping("/daily-return")
    public ResponseEntity<DailyReturnDTO> getDailyReturn(@RequestParam("date") String date) {
        DailyReturnDTO dailyReturn = investmentService.calculateDailyReturn(date);
        return ResponseEntity.ok(dailyReturn);
    }

    @GetMapping("/actions-on-day")
    public ResponseEntity<List<ActionDTO>> getActionsOnDay(@RequestParam("date") String date) {
        List<ActionDTO> actionsOnDay = investmentService.getActionsOnDay(date);
        return ResponseEntity.ok(actionsOnDay);
    }

    @GetMapping("/period-return")
    public ResponseEntity<PeriodReturnDTO> getPeriodReturn(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) {
        PeriodReturnDTO periodReturn = investmentService.calculatePeriodReturn(startDate, endDate);
        return ResponseEntity.ok(periodReturn);
    }

    @GetMapping("/detailed-period-return")
    public ResponseEntity<DetailedPeriodReturnDTO> getDetailedPeriodReturn(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) {
        DetailedPeriodReturnDTO detailedPeriodReturn = investmentService.calculateDetailedPeriodReturn(startDate, endDate);
        return ResponseEntity.ok(detailedPeriodReturn);
    }
}
*
 */