import React, { Component } from "react";
import axios from "axios";

function getDisplayName(WrappedComponent) {
  return WrappedComponent.displayName || WrappedComponent.name || 'Component';
}

export function withApiProgress(WrappedComponent, apiPath) {
  return class extends Component {

    static displayName = `ApiProgress(${getDisplayName(WrappedComponent)})`;

    //<======================================================>
    state = {
      pendingApiCall: false,
    };
    //<======================================================>
    // Axios Intercepter for button spinner.
    componentDidMount() {
      this.requestInterceptor = axios.interceptors.request.use((request) => {
        this.updateApiCallFor(request.url, true);
        return request;
      });
  
      this.responseInterceptor = axios.interceptors.response.use(
        (response) => {
          this.updateApiCallFor(response.config.url, false);
          return response;
        },
        (error) => {
          this.updateApiCallFor(error.config.url, false);
          throw error;
        }
      );
    }
    //<======================================================>
    /* Sayfalar route edildikce Interceptor'lar silinmedigi icin memory'de birikirler.
    Browserlarda depolanir bu yuzden bir yere istek atarken 10 kere sayfa yönlendirdiysek 
    10 request atacaktir. Bunun silinmesi gerekir.*/  
      componentWillUnmount() { 
      axios.interceptors.request.eject(this.requestInterceptor); 
      axios.interceptors.response.eject(this.responseInterceptor); 
    } 
    //<======================================================>
    updateApiCallFor = (url, inProgress) => {
      if (url === apiPath) {
        this.setState({ pendingApiCall: inProgress });
      }
    };
    //<======================================================>
    render() {
      const pendingApiCall = this.state.pendingApiCall || this.props.pendingApiCall; 
      return <WrappedComponent {...this.props} pendingApiCall={pendingApiCall} />; 
    }
  }
}