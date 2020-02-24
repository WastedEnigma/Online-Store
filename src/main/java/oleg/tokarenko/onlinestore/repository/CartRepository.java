package oleg.tokarenko.onlinestore.repository;

import oleg.tokarenko.onlinestore.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("select distinct c from Cart c join c.user u where u.username = :username")
    Optional<Cart> findCartByUsername(@Param("username") String username);
}
