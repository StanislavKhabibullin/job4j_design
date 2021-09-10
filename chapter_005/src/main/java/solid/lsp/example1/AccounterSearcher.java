package solid.lsp.example1;

import java.util.List;
import java.util.Map;

public class AccounterSearcher {
    /* класс по приему бухгалтера на работу,
    в questionsAnswers - базовый набор вопросов при приеме бухгалтера на работу
    для дальнейшего собеседования требуется чтобы бухгалтер на все прилагаемые вопрос
    дал положительный ответ по компетенциям
     */

   public boolean basicCriteria(Map<String, Boolean> questionsAnswers) {
       boolean result = true;
       for (Map.Entry<String, Boolean> item :
               questionsAnswers.entrySet()) {
           if (item.getValue() != true) {
               result = false;
           }
       }

       return result;
   }
}
