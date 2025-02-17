package org.example;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import java.util.List;
import java.util.stream.Collectors;

public class ModifyCsvProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        // Получаем тело сообщения как List<List<String>> (CSV после разархивации)
        List<List<String>> csvData = exchange.getIn().getBody(List.class);

        // Добавляем "MODIFIED: " в начало каждой строки
        List<List<String>> modifiedCsv = csvData.stream()
                .map(row -> row.stream().map(cell -> "MODIFIED: " + cell).collect(Collectors.toList()))
                .collect(Collectors.toList());

        // Записываем обратно в сообщение
        exchange.getIn().setBody(modifiedCsv);
    }
}
