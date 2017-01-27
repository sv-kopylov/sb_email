package sb_email.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import sb_email.persist.PostBox;

/**
 * Created by Сергей on 26.01.2017.
 */
@Transactional
public interface PostBoxDao extends CrudRepository <PostBox, Long> {
    public PostBox findByLogin (String login);

}
