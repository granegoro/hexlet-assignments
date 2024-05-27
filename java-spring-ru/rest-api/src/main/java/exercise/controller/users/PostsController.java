package exercise.controller.users;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import exercise.model.Post;
import exercise.Data;

import static java.util.stream.Collectors.toList;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {

    private List<Post> posts = Data.getPosts();

    @GetMapping("/users/{userId}/posts")
    //список всех постов, написанных пользователем с таким же userId, как id в маршруте
    public List<Post> show(@PathVariable Integer userId) {
        return posts.stream().filter(p -> p.getUserId() == userId).toList();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/users/{id}/posts") //создание нового поста, привязанного к пользователю по id
    public Post create(@PathVariable Integer userId, @RequestBody Post post) {
        post.setUserId(userId);
        posts.add(post);
        return post;
    }
}
// END
