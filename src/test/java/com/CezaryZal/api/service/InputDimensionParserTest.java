package com.CezaryZal.api.service;

import com.CezaryZal.api.model.ParsedInputDimension;
import com.CezaryZal.api.service.validation.InputValidator;
import com.CezaryZal.exceptions.InvalidInputException;
import com.CezaryZal.exceptions.InvalidSymbolsException;
import com.CezaryZal.exceptions.InvalidValueOfDimensionException;
import com.CezaryZal.exceptions.InvalidValueOfItException;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static com.CezaryZal.constant.DescriptionOfConstants.DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT;
import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class InputDimensionParserTest {

    @Spy
    private InputValidator inputValidator;

    @InjectMocks
    private InputDimensionParser inputDimensionParser;

    @Test
    public void parse_input_dimension_should_throw_invalid_value_of_dimension_exception() {
        assertThrows(
                InvalidValueOfDimensionException.class, () -> inputDimensionParser.parseInputDimension("0a2"));
        assertThrows(
                InvalidValueOfDimensionException.class, () -> inputDimensionParser.parseInputDimension("501a2"));
    }

    @Test
    public void parse_input_dimension_should_throw_invalid_symbols_exception() {
        assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1aa2"));
        assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1t2"));
        assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1T2"));
        assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1b2"));
        assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1i2"));
        assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1l2"));
        assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1o2"));
        assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1q2"));
        assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1B2"));
        assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1I2"));
        assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1L2"));
        assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1O2"));
        assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1Q2"));
    }

    @Test
    public void parse_input_dimension_should_throw_invalid_value_of_IT_exception() {
        assertThrows(
                InvalidValueOfItException.class, () -> inputDimensionParser.parseInputDimension("1a0"));
        assertThrows(
                InvalidValueOfItException.class, () -> inputDimensionParser.parseInputDimension("1a19"));
    }

    @Test
    public void parse_input_dimension_should_throw_invalid_input_exception() {
        assertThrows(
                InvalidInputException.class, () -> inputDimensionParser.parseInputDimension(""));
        assertThrows(
                InvalidInputException.class, () -> inputDimensionParser.parseInputDimension("4%5E5k7"));
        assertThrows(
                InvalidInputException.class, () -> inputDimensionParser.parseInputDimension("5^1k8"));
        assertThrows(
                InvalidInputException.class, () -> inputDimensionParser.parseInputDimension("50t8k"));
        assertThrows(
                InvalidInputException.class, () -> inputDimensionParser.parseInputDimension("50t8k6"));
        assertThrows(
                InvalidInputException.class, () -> inputDimensionParser.parseInputDimension("58"));
        assertThrows(
                InvalidInputException.class, () -> inputDimensionParser.parseInputDimension("k8"));
        assertThrows(
                InvalidInputException.class, () -> inputDimensionParser.parseInputDimension("80G"));
    }

    @SneakyThrows
    @Test
    public void parse_input_dimension_should_not_throw_exceptions() {
        ParsedInputDimension parsedInputDimensionFrom1M7 = inputDimensionParser.parseInputDimension("1M7");
        ParsedInputDimension parsedInputDimensionFrom500m5 = inputDimensionParser.parseInputDimension("500m5");
        ParsedInputDimension parsedInputDimensionFrom55a3 = inputDimensionParser.parseInputDimension("55a3");
        ParsedInputDimension parsedInputDimensionFrom72s4 = inputDimensionParser.parseInputDimension("72s4");
        ParsedInputDimension parsedInputDimensionFrom8A2 = inputDimensionParser.parseInputDimension("8A2");
        ParsedInputDimension parsedInputDimensionFrom43S4 = inputDimensionParser.parseInputDimension("43S4");
        ParsedInputDimension parsedInputDimensionFrom22n1 = inputDimensionParser.parseInputDimension("22n1");
        ParsedInputDimension parsedInputDimensionFrom89K18 = inputDimensionParser.parseInputDimension("89K18");

        ParsedInputDimension expectedParsedInputDimensionFrom1M7 = new ParsedInputDimension(1, 'M', 7);
        ParsedInputDimension expectedParsedInputDimensionFrom500m5 = new ParsedInputDimension(500, 'm', 5);
        ParsedInputDimension expectedParsedInputDimensionFrom55a3 = new ParsedInputDimension(55, 'a', 3);
        ParsedInputDimension expectedParsedInputDimensionFrom72s4 = new ParsedInputDimension(72, 's', 4);
        ParsedInputDimension expectedParsedInputDimensionFrom8A2 = new ParsedInputDimension(8, 'A', 2);
        ParsedInputDimension expectedParsedInputDimensionFrom43S4 = new ParsedInputDimension(43, 'S', 4);
        ParsedInputDimension expectedParsedInputDimensionFrom22n1 = new ParsedInputDimension(22, 'n', 1);
        ParsedInputDimension expectedParsedInputDimensionFrom89K18 = new ParsedInputDimension(89, 'K', 18);

        then(parsedInputDimensionFrom1M7)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT)
                .isEqualTo(expectedParsedInputDimensionFrom1M7);
        then(parsedInputDimensionFrom500m5)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT)
                .isEqualTo(expectedParsedInputDimensionFrom500m5);
        then(parsedInputDimensionFrom55a3)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT)
                .isEqualTo(expectedParsedInputDimensionFrom55a3);
        then(parsedInputDimensionFrom72s4)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT)
                .isEqualTo(expectedParsedInputDimensionFrom72s4);
        then(parsedInputDimensionFrom8A2)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT)
                .isEqualTo(expectedParsedInputDimensionFrom8A2);
        then(parsedInputDimensionFrom43S4)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT)
                .isEqualTo(expectedParsedInputDimensionFrom43S4);
        then(parsedInputDimensionFrom22n1)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT)
                .isEqualTo(expectedParsedInputDimensionFrom22n1);
        then(parsedInputDimensionFrom89K18)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT)
                .isEqualTo(expectedParsedInputDimensionFrom89K18);
    }
}