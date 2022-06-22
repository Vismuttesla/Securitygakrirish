package com.example.demo.repository;

import com.example.demo.entity.User1;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User1>
{
Optional<User1> findByEmail(String email);

}
