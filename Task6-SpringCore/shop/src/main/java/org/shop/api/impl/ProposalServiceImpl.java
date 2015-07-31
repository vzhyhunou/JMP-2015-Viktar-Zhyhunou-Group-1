package org.shop.api.impl;

import java.util.List;

import org.shop.api.ProductService;
import org.shop.api.ProposalService;
import org.shop.api.SellerService;
import org.shop.data.Product;
import org.shop.data.Proposal;
import org.shop.data.Seller;
import org.shop.data.State;
import org.shop.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProposalServiceImpl implements ProposalService {

    private ProposalRepository repository;
    
    @Autowired
    private SellerService sellerService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    public ProposalServiceImpl(ProposalRepository repository) {
        super();
        this.repository = repository;
    }
    
    /* (non-Javadoc)
     * @see org.shop.api.ProposalService#createProposal(java.lang.Long, java.lang.Long, java.lang.Double)
     */
    @Override
    public Long createProposal(Long sellerId, Long productId, Double price) {
        Proposal proposal = new Proposal();
        proposal.setPrice(price);
        proposal.setProduct(productService.getProductById(productId));
        proposal.setSeller(sellerService.getSellerById(sellerId));
        proposal.setState(State.NOT_ACTIVE_PROPOSAL);
        
        return repository.createProposal(proposal);
    }

    /* (non-Javadoc)
     * @see org.shop.api.ProposalService#deactivateProposal(java.lang.Long)
     */
    @Override
    public void deactivateProposal(Long proposalId) {
        Proposal proposal = repository.getProposal(proposalId);
        proposal.setState(State.NOT_ACTIVE_PROPOSAL);
        
        repository.updateProposal(proposal);
    }

    /* (non-Javadoc)
     * @see org.shop.api.ProposalService#activateProposal(java.lang.Long)
     */
    @Override
    public void activateProposal(Long proposalId) {
        Proposal proposal = repository.getProposal(proposalId);
        proposal.setState(State.ACTIVE_PROPOSAL);
        
        repository.updateProposal(proposal);
    }

    /* (non-Javadoc)
     * @see org.shop.api.ProposalService#getProposalsByProduct(org.shop.data.Product)
     */
    @Override
    public final List<Proposal> getProposalsByProduct(Product product) {
        return getProposalsByProductId(product.getId());
    }

    /* (non-Javadoc)
     * @see org.shop.api.ProposalService#getProposalsByProductId(java.lang.Long)
     */
    @Override
    public List<Proposal> getProposalsByProductId(Long productId) {
        return repository.getProposalsByProductId(productId);
    }

    /* (non-Javadoc)
     * @see org.shop.api.ProposalService#getProposalsBySeller(org.shop.data.Seller)
     */
    @Override
    public final List<Proposal> getProposalsBySeller(Seller seller) {
        return getProposalsBySellerId(seller.getId());
    }

    /* (non-Javadoc)
     * @see org.shop.api.ProposalService#getProposalsBySellerId(java.lang.Long)
     */
    @Override
    public List<Proposal> getProposalsBySellerId(Long sellerId) {
        return repository.getProposalsBySellerId(sellerId);
    }
}
