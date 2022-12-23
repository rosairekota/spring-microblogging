package com.godsonpeya.microblog.service

import com.godsonpeya.microblog.entity.Post
import com.godsonpeya.microblog.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class PostService @Autowired constructor(private var postRepository: PostRepository) {


   fun getAll():List<Post> = postRepository.findAll() 

   fun getOne(id: Long ): Post {
    return postRepository.findById(id).orElseThrow{ IllegalArgumentException("this post is not found")}
   }
   fun savePost(post: Post): Post = postRepository.save(post)
   fun updatePost(id: Long, postDto: Post): Post {
      try {
         val postFound = getOne(id)
         postFound.content = postDto.content
         postFound.userId = postDto.userId
         return postRepository.save(postFound)
      }
      catch(Exception e) {
         throw IllegalArgumentException("error ..")
      }
   }
   fun deletePost(id:Long): Boolean {
      postFound = getOne(id)
       try {
         postRepository.delete(postFound)
         return "post deleted"
       }
       catch(Exception e) {
         return "error for "
       }
      
   }
}