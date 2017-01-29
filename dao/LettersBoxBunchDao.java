package sb_email.dao;

import org.springframework.data.repository.CrudRepository;
import sb_email.persist.Letter;
import sb_email.persist.LetterBoxBunch;
import sb_email.persist.PostBox;

import java.util.List;

/**
 * Created by Сергей on 27.01.2017.
 */
public interface LettersBoxBunchDao extends CrudRepository<LetterBoxBunch, Long> {
   public List<LetterBoxBunch> findByPostBox(PostBox postBox);
   public List<LetterBoxBunch> findByLetter(Letter letter);

}
