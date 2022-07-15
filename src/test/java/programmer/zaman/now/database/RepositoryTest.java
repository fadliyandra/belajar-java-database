package programmer.zaman.now.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.database.entity.Comment;
import programmer.zaman.now.database.repository.CommentRepository;
import programmer.zaman.now.database.repository.CommentRepositoryImpl;

public class RepositoryTest {

private CommentRepository commentRepository;

    @BeforeEach
    void setUp() {
        commentRepository = new CommentRepositoryImpl();

    }

    @Test
    void testInsert() {
        Comment comment = new Comment("eko@test.com", "hi");
        commentRepository.insert(comment);

        Assertions.assertNotNull(comment.getId());
    }
}
