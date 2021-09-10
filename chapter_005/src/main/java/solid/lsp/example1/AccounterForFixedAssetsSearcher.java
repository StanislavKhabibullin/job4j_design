package solid.lsp.example1;

import java.util.Map;

public class AccounterForFixedAssetsSearcher extends AccounterSearcher {
    /*
    класс для поиска бухгалтера на участок основных средств
     */
    @Override
    public boolean basicCriteria(Map<String, Boolean> questionsAnswers) {
        boolean result = true;
        for (Map.Entry<String, Boolean> item :
                questionsAnswers.entrySet()) {
            if (!(item.getKey().equals("ability to work in the 1c program"))  //добавляем доп условие к методу базового класса
                    &  item.getValue() != true) {
                result = false;
            }
        }

        return result;
    }
}
