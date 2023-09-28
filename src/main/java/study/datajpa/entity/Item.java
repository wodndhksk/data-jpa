package study.datajpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * id 가 자동 채번이 아닌 경우 jpa 구현체 save() 에서는 em.persist 를 하지 않는다.
 * (왜냐하면 em.persist 시 이미 id가 존재하므로 새로운 엔티티라고 판단하지 않기 때문.)
 * 따라서 로직을 수정 -> Persistable 를 implements 하고 isNew()를 createdDate ===null 인지로 판별하게끔 수정해야함.
 *
 * jpa 구현체인 save() 에서 디버깅을 통해 확인 가능.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item implements Persistable<String> {
    @Id
    private String id;

    @CreatedDate
    private LocalDateTime createdDate;

    public Item(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return createdDate == null;
    }
}
