# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|

  # SSH forwarding: See https://help.github.com/articles/using-ssh-agent-forwarding
  config.ssh.forward_agent = true

  basebox = "precise64"
  baseurl = "http://files.vagrantup.com/precise64.box"

  config.vm.define :ubuntu do |ubuntu|

    ubuntu.vm.box = basebox
    ubuntu.vm.box_url = baseurl

    ubuntu.vm.provider :virtualbox do |vb|
      vb.customize ["modifyvm", :id, "--memory", "2048"]
    end

    ubuntu.vm.network :private_network, ip: "192.168.90.101"
    ubuntu.vm.hostname = "ubuntu"

  end

end
