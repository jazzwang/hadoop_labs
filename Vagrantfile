# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|

  # SSH forwarding: See https://help.github.com/articles/using-ssh-agent-forwarding
  config.ssh.forward_agent = true

  config.vm.box = "ubuntu/trusty64"

  config.vm.define :ubuntu do |ubuntu|

    ubuntu.vm.provider :virtualbox do |vb|
      vb.customize ["modifyvm", :id, "--memory", "2048"]
    end

    ubuntu.vm.network :private_network, ip: "192.168.90.101"
    ubuntu.vm.hostname = "ubuntu"

  end

end
