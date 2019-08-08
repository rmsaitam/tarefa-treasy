package br.saitam.treasy.service;

import java.util.Hashtable;
import br.saitam.treasy.model.Node;
import br.saitam.treasy.repository.NodeRepository;

/**
 * Camada para as regras de negócio
 */
public class NodeService {

	/**
	 * Um pai não pode ser filho de seu filho ou seus decendentes
	 *
	 *
	 * @param Node node
	 * @param NodeRepository repository
	 * @return boolean
	 */
	public static boolean isDescendant(Node node, NodeRepository repository) {
		return search(repository.getOne(node.getId()), node.getParent().getId());
	}

	/**
	 * Realiza a busca na árvore comparando os valores.
	 *
	 *
	 * @param Node node
	 * @param Long parentId
	 * @return boolean
	 */
	private static boolean search(Node node, Long parentId) {
		return node.getChildrens().stream().anyMatch(chidren -> {
			if (chidren.getId() == parentId) {
				return true;
			} else {
				return (chidren.getChildrens().size() > 0) ? search(chidren, parentId) : false;
			}
		});
	}

	/**
	 * Defina a estrutura para a resposta (Valor único)
	 *
	 * @param <T>
	 *
	 * @param String key
	 * @param T body
	 * @return Hashtable<String, T>
	 */
	public static <T> Hashtable<String, T> response(String key, T body) {
		Hashtable<String, T> output = new Hashtable<String, T>();
		output.put(key, body);
		return output;
	}
}
