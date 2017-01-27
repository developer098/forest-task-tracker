Ext.define('ForestTaskTracker.view.login.Login', {
    extend: 'Ext.window.Window',
    xtype: 'login',

    requires: [
        'Ext.form.Panel',
        'ForestTaskTracker.view.login.LoginController'
    ],

    controller: 'login',
    bodyPadding: 10,
    title: 'Вход',
    closable: false,
    autoShow: true,
    items: {
        xtype: 'form',
        reference: 'form',
        items: [{
            xtype: 'textfield',
            name: 'username',
            fieldLabel: 'Имя',
            allowBlank: false
        }, {
            xtype: 'textfield',
            name: 'password',
            inputType: 'password',
            fieldLabel: 'Пароль',
            allowBlank: false
        }],
        buttons: [{
            text: 'Login',
            formBind: true,
            listeners: {
                click: 'onLoginClick'
            }
        }]
    }
});