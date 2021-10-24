package solid.lsp.example1;

import java.util.Map;

public class AccounterForFixedAssetsSearcher extends AccounterSearcher {
    /**
    класс для поиска бухгалтера на участок основных средств
     */
    @Override
    public boolean basicCriteria(Map<String, Boolean> questionsAnswers) {
        boolean result = true;
        for (Map.Entry<String, Boolean> item
                :questionsAnswers.entrySet()) {
            /**
             *  //добавляем доп условие к методу базового класса
             */
            if (!(item.getKey().equals("ability to work in the 1c program"))
                    &  !(item.getValue())) {
                result = false;
            }
        }

        return result;
    }
}
