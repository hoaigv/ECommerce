package com.challenge.ecommerce.products.repositories;

import com.challenge.ecommerce.products.models.OptionValueEntity;
import com.challenge.ecommerce.products.models.VariantValueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VariantValueRepository extends JpaRepository<VariantValueEntity, String> {
  @Query(
      "SELECT b.optionValue FROM variant_values b WHERE b.option.id=:optionId AND b.variant.id=:variantId AND b.deletedAt IS NULL")
  List<OptionValueEntity> findByVariantIdAndOptionIdAndDeletedAtIsNull(
      @Param("variantId") String variantId, @Param("optionId") String optionId);
}