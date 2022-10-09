package pro.sky.calculator;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculator.service.CalculatorService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calculator")

public class CalculatorController {

    private final CalculatorService calculatorService;

    @GetMapping
    public String welcome() {
        return "<mark><b>Добро пожаловать в калькулятор.</b></mark>";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(name = "num1", required = false) Integer a,
                       @RequestParam(name = "num2", required = false) Integer b) {
        if(a == null || b == null) return "Не данны одно из двух параметров";
        int plus = calculatorService.plus(a, b);
    return a + " + " + b + " = " + plus;
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(name = "num1", required = false) Integer a,
                       @RequestParam(name = "num2", required = false) Integer b) {
        if(a == null || b == null) return "Не данны одно из двух параметров";
        int minus = calculatorService.minus(a, b);
    return a + " - " + b + " = " + minus;
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(name = "num1", required = false) Integer a,
                       @RequestParam(name = "num2", required = false) Integer b) {
        if(a == null || b == null) return "Не данны одно из двух параметров";
        int multiply = calculatorService.multiply(a, b);
    return a + " * " + b + " = " + multiply;
    }

    @GetMapping("/share")
    public String share(@RequestParam(name = "num1", required = false) Integer a,
                       @RequestParam(name = "num2", required = false) Integer b) {
        if(a == null || b == null) return "Не данны одно из двух параметров";
        double share;
        try {
            share = calculatorService.share(a, b);
        } catch (Throwable i) {
            return i.getMessage();
        }
        return a + " / " + b + " = " + share;
    }

}
