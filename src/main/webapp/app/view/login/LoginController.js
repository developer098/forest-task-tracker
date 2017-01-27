Ext.define('ForestTaskTracker.view.login.LoginController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.login',

    onLoginClick: function() {
        // This would be the ideal location to verify the user's credentials via
        // a server-side lookup. We'll just move forward for the sake of this example.
        localStorage.setItem("ForestTaskLoggedIn", true);
        this.getView().destroy();
        Ext.create({
            xtype: 'app-main'
        });
    }
});