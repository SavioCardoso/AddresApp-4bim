//@author Savio Cardoso, Marco Jakob

package Controllers;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import Model.Person;

public class BirthdayStatisticsController {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;

    private ObservableList<String> monthNames = FXCollections.observableArrayList();

    /**
     * Inicializa a classe controller. 
     * Este método é chamado após o arquivo fxml ter sido carregado.
     */
    @FXML
    private void initialize() {
        // Obtém an array com nomes dos meses em Inglês.
        String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getMonths();
        // Converte o array em uma lista e adiciona em nossa ObservableList de meses.
        monthNames.addAll(Arrays.asList(months));
        
        // Associa os nomes de mês como categorias para o eixo horizontal.
        xAxis.setCategories(monthNames);
    }

     /**
     * Adiciona Dados Ao Grafico EstatisticasDeAniversarios.
     * 
     * @param persons
     */
    public void setPersonDataToBirthdayStatistics(List<Person> persons) {
        // Conta o número de pessoas tendo seus aniversários em um mês específico.
        int[] monthCounter = new int[12];
        for (Person p : persons) {
            int month = p.getBirthday().getMonthValue() - 1;
            monthCounter[month]++;
        }

        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        
        // Cria um objeto XYChart.Data para cada mês. Adiciona ele às séries.
        for (int i = 0; i < monthCounter.length; i++) {
            series.getData().add(new XYChart.Data<>(monthNames.get(i), monthCounter[i]));
        }
        
        barChart.getData().add(series);
    }
}
