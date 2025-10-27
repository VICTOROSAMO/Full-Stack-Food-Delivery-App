import React, { useContext } from 'react';
import './PlaceOrder.css';
import { assets } from '../../assets/assets';
import { StoreContext } from '../../context/StoreContext';
import { calculateCartTotals } from '../../util/CartUtils';

const PlaceOrder = () => {

  const{foodList, quantities, setQuantities} = useContext(StoreContext); 
  
    //cart items
    const cartItems = foodList.filter((food) => quantities[food.id] > 0);

    //calculating
    const {subtotal, shipping, tax, total} = calculateCartTotals(cartItems, quantities)



  return (
    <div className="container mt-4">
      <div className="py-5 text-center">
      <img className="d-block mx-auto" src={assets.logo} alt="" width="98" height="98" />
      
    </div>
      <div className="row">
        {/* Cart Section */}
        <div className="col-md-5 col-lg-4 order-md-last">
          <h4 className="d-flex justify-content-between align-items-center mb-3">
            <span className="text-primary">Your cart</span>
            <span className="badge bg-primary rounded-pill">{cartItems.length}</span>
          </h4>
          <ul className="list-group mb-3">
            {cartItems.map(item => (
              <li className="list-group-item d-flex justify-content-between lh-sm">
              <div>
                <h6 className="my-0">{item.name}</h6>
                <small className="text-muted">Qty: {quantities[item.id]}</small>
              </div>
              <span className="text-muted">Ksh{item.price * quantities[item.id]}</span>
            </li>
            ))}
            <li className="list-group-item d-flex justify-content-between">
              <div>
                <span>Shipping</span>
              </div>
              <span className="text-muted">Ksh{subtotal === 0 ? 0.00 : shipping.toFixed(2)}</span>
            </li>
            <li className="list-group-item d-flex justify-content-between">
              <div>
                <span>Tax (10%)</span>
              </div>
              <span className="text-muted">Ksh{tax.toFixed(2)}</span>
            </li>
            
            <li className="list-group-item d-flex justify-content-between">
              <span>Total (Ksh)</span>
              <strong>Ksh{total.toFixed(2)}</strong>
            </li>
          </ul>

        </div>

        {/* Billing Form */}
        <div className=" col-md-7 col-lg-8">
          <h4 className="mb-3">Billing address</h4>
          <form className="needs-validation" noValidate>
            <div className="row g-3">
              <div className="col-sm-6">
                <label htmlFor="firstName" className="form-label">First name</label>
                <input type="text" className="form-control" id="firstName" placeholder='John' required />
                <div className="invalid-feedback">Valid first name is required.</div>
              </div>

              <div className="col-sm-6">
                <label htmlFor="lastName" className="form-label" >Last name</label>
                <input type="text" className="form-control" id="lastName" required placeholder='Doe' />
                <div className="invalid-feedback">Valid last name is required.</div>
              </div>

              <div className="col-12">
                <label htmlFor="email" className="form-label">Email (Optional)</label>
                <input type="email" className="form-control" id="email" placeholder="you@example.com" />
                <div className="invalid-feedback">Please enter a valid email address.</div>
              </div>

              <div className="col-12">
                <label htmlFor="phone" className="form-label">Phone Number</label>
                <input type="number" className="form-control" id="phone" placeholder="2547XXXXXXXX" required />
                <div className="invalid-feedback">Please enter your phone number.</div>
              </div>

              <div className="col-12">
                <label htmlFor="address" className="form-label">Address</label>
                <input type="text" className="form-control" id="address" placeholder="1234 Main St" required />
                <div className="invalid-feedback">Please enter your shipping address.</div>
              </div>

              <div className="col-md-5">
                <label htmlFor="country" className="form-label">Country</label>
                <select className="form-select" id="country" required>
                  <option value="">Choose...</option>
                  <option>United States</option>
                </select>
                <div className="invalid-feedback">Please select a valid country.</div>
              </div>

              <div className="col-md-4">
                <label htmlFor="state" className="form-label">State</label>
                <select className="form-select" id="state" required>
                  <option value="">Choose...</option>
                  <option>California</option>
                </select>
                <div className="invalid-feedback">Please provide a valid state.</div>
              </div>

              <div className="col-md-3">
                <label htmlFor="zip" className="form-label">Zip</label>
                <input type="text" className="form-control" id="zip" required />
                <div className="invalid-feedback">Zip code required.</div>
              </div>
            </div>

            <hr className="my-4" />

            <button className="w-100 btn btn-primary btn-lg" type="submit" disabled={cartItems.length === 0}>
              Continue to checkout
            </button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default PlaceOrder;
