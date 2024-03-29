package br.saitam.treasy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.saitam.treasy.model.Node;


@Repository
public interface NodeRepository extends JpaRepository<Node, Long> {
	/**
	 * Order by id desc
	 *
	 */
	public List<Node> findAllByOrderByIdDesc();


}