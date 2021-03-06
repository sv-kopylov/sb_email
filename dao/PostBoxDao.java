package sb_email.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sb_email.persist.PostBox;

import java.util.List;

/**
 * Created by Сергей on 26.01.2017.
 */
@Repository
@Transactional
public interface PostBoxDao extends CrudRepository <PostBox, Long> {
    public PostBox findByLogin (String login);
    public List<PostBox> findByName (String name);

}
