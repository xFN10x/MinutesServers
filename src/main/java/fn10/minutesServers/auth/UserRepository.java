package fn10.minutesServers.auth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<TMUser, Long> {

    
}
