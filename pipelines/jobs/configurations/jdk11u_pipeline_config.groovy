class Config11 {
  final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac    : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.osx.10_14',
                test                : 'default',
                configureArgs       : [
                        "openj9"      : '--enable-dtrace=auto  --with-vendor-name="IBM Corp." --with-vendor-version-string="11.0.12.0" --with-launcher-name=semeru --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-jdk-rc-name="IBM Semeru Platform"'
                ]
        ],

        x64Linux  : [
                os                  : 'linux',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
                dockerImage         : 'adoptopenjdk/centos6_build_image@sha256:19cdb5284da031aef7c73cb52ee7018502d65d0ca21cebc45d9652eec3926458',
                dockerFile: [
                        openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                dockerNode          : 'sw.tool.docker && sw.config.uid1000',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                test                : 'default',
                configureArgs       : [
                        "openj9"      : '--enable-jitserver --enable-dtrace=auto --with-vendor-name="IBM Corp." --with-vendor-version-string="11.0.12.0" --with-launcher-name=semeru --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-jdk-rc-name="IBM Semeru Platform"'
                ]
        ],

        x64Windows: [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: [
                        openj9:     'ci.project.openj9 && hw.arch.x86 && sw.os.windows'
                ],
                test                : 'default',
                configureArgs       : [
                        "openj9"      : '--with-vendor-name="IBM Corp." --with-vendor-version-string="11.0.12.0" --with-launcher-name=semeru --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-jdk-rc-name="IBM Semeru Platform"'
                ]
        ],

        ppc64Aix    : [
                os                  : 'aix',
                arch                : 'ppc64',
                additionalNodeLabels: [
                        openj9:  'hw.arch.ppc64 && sw.os.aix.7_1'
                ],
                test                : 'default',
                configureArgs       : [
                        "openj9"      : '--with-vendor-name="IBM Corp." --with-vendor-version-string="11.0.12.0" --with-launcher-name=semeru --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-jdk-rc-name="IBM Semeru Platform"'
                ]
        ],

        s390xLinux    : [
                os                  : 'linux',
                arch                : 's390x',
                test                : 'default',
                additionalNodeLabels: [
                        openj9:  'hw.arch.s390x && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs       : '--enable-dtrace=auto --with-vendor-name="IBM Corp." --with-vendor-version-string="11.0.12.0" --with-launcher-name=semeru --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-jdk-rc-name="IBM Semeru Platform"'
        ],

        ppc64leLinux    : [
                os                  : 'linux',
                arch                : 'ppc64le',
                additionalNodeLabels : 'centos7',
                test                : 'default',
                additionalNodeLabels: [
                        openj9:  'hw.arch.ppc64le && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs       : [
                        "openj9"      : '--enable-dtrace=auto --enable-jitserver --with-vendor-name="IBM Corp." --with-vendor-version-string="11.0.12.0" --with-launcher-name=semeru --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-jdk-rc-name="IBM Semeru Platform"'
                ]

        ],

        aarch64Linux    : [
                os                  : 'linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/centos7_build_image@sha256:e8ab3ee5aab3f78f88a39bacadbd4c9e87c7e2ff8fb7a9f7917427568ccf9ddd',
                dockerNode         : 'sw.tool.docker',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                additionalNodeLabels: [
                        openj9:  'hw.arch.aarch64 && sw.os.linux'
                ],
                test                : 'default',
                configureArgs       : [
                        "hotspot" : '--enable-dtrace=auto',
                        "openj9" : '--enable-dtrace=auto --with-version-pre=ea --without-version-opt  --with-vendor-name="IBM Corp." --with-vendor-version-string="11.0.12.0" --with-launcher-name=semeru --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-jdk-rc-name="IBM Semeru Platform"',
                        "corretto" : '--enable-dtrace=auto',
                        "dragonwell" : "--enable-dtrace=auto --with-extra-cflags=\"-march=armv8.2-a+crypto\" --with-extra-cxxflags=\"-march=armv8.2-a+crypto\"",
                        "bisheng" : '--enable-dtrace=auto --with-extra-cflags=-fstack-protector-strong --with-extra-cxxflags=-fstack-protector-strong --with-jvm-variants=server'
                ]
        ]
  ]

}

Config11 config = new Config11()
return config.buildConfigurations
