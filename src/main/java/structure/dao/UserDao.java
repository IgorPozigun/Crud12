package structure.dao;

import structure.model.User;

import java.util.List;

public interface UserDao {
     void addUser(User user); // добавление юзера

     void deleteUser(User user); // удаление

     void updateUser(User user); // изменять

     User getUserById(int id); // получение юзера по id

     List<User> allUsers(); // выводит всех юзеров
}
