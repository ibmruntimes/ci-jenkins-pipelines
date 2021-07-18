class Config8 {
  final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac        : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels: [
                        hotspot : 'macos10.14',
                        corretto: 'build-macstadium-macos1010-1',
                        openj9  : 'ci.project.openj9 && hw.arch.x86 && sw.os.osx.10_14'
                ],
                cleanWorkspaceAfterBuild: true,
                configureArgs      : '--with-vendor-name="IBM Corp." --with-launcher-name=semeru --with-product-name=Semeru --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues',
                test                 : 'default'
        ],

        x64Linux      : [
                os                  : 'linux',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
                dockerImage         : 'adoptopenjdk/centos6_build_image@sha256:643fa990a41dbaf448a24b2e189e69ef9d06ef1cd077ca78208dab35a2d48a19',
                dockerFile: [
                        openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile',
                        dragonwell: 'pipelines/build/dockerFiles/dragonwell.dockerfile'
                ],
                dockerNode          : 'sw.tool.docker && sw.config.uid1000',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                test                 : 'default',
                configureArgs       : [
                        "openj9"      : '--enable-jitserver --with-vendor-name="IBM Corp." --with-launcher-name=semeru --with-product-name=Semeru --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues',
                        "dragonwell"  : '--enable-unlimited-crypto --with-jvm-variants=server  --with-zlib=system',
                ]
        ],

        x64Windows    : [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: [
                        hotspot : 'win2012',
                        corretto: 'win2012',
                        openj9  : 'ci.project.openj9 && hw.arch.x86 && sw.os.windows',
                        dragonwell: 'win2012'
                ],
                configureArgs      : '--with-vendor-name="IBM Corp." --with-launcher-name=semeru --with-product-name=Semeru --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues',
                test                 : 'default'
        ],

        x32Windows    : [
                os                  : 'windows',
                arch                : 'x86-32',
                additionalNodeLabels: [
                        hotspot : 'win2012',
                        corretto: 'win2012',
                        openj9  : 'ci.project.openj9 && hw.arch.x86 && sw.os.windows'
                ],
                buildArgs : [
                        hotspot : '--jvm-variant client,server'
                ],
                configureArgs      : '--with-vendor-name="IBM Corp." --with-launcher-name=semeru --with-product-name=Semeru --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues',
                test                 : 'default'
        ],

        ppc64Aix      : [
                os  : 'aix',
                arch: 'ppc64',
                additionalNodeLabels: [
                        hotspot: 'xlc13&&aix710',
                        openj9:  'hw.arch.ppc64 && sw.os.aix.7_1'
                ],
                test                 : 'default',
                configureArgs: [
                    "openj9"        : '--disable-ccache --with-vendor-name="IBM Corp." --with-launcher-name=semeru --with-product-name=Semeru --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
                ],
                cleanWorkspaceAfterBuild: true
        ],

        s390xLinux    : [
                os  : 'linux',
                arch: 's390x',
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9:  'hw.arch.s390x && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs      : '--with-vendor-name="IBM Corp." --with-launcher-name=semeru --with-product-name=Semeru --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues',
                test: [
                        hotspot: ['sanity.openjdk'],
                        openj9: 'default'
                ]
        ],

        ppc64leLinux  : [
                os  : 'linux',
                arch: 'ppc64le',
                additionalNodeLabels : 'centos7',
                test                 : 'default',
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9:  'hw.arch.ppc64le && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs       : [
                        "openj9"      : '--enable-jitserver --with-vendor-name="IBM Corp." --with-launcher-name=semeru --with-product-name=Semeru --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues'
                ]
        ],

        aarch64Linux  : [
                os                  : 'linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/centos7_build_image@sha256:e8ab3ee5aab3f78f88a39bacadbd4c9e87c7e2ff8fb7a9f7917427568ccf9ddd',
                dockerFile: [
                        dragonwell: 'pipelines/build/dockerFiles/dragonwell_aarch64.dockerfile'
                ],
                dockerNode         : 'sw.tool.docker',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                additionalNodeLabels: [
                        openj9:  'hw.arch.aarch64 && sw.os.linux'
                ],
                configureArgs      : '--with-vendor-name="IBM Corp." --with-launcher-name=semeru --with-product-name=Semeru --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://github.com/eclipse-openj9/openj9/issues --with-vendor-vm-bug-url=https://github.com/eclipse-openj9/openj9/issues',
                cleanWorkspaceAfterBuild: true,
                test                 : 'default'
        ]
  ]

}

Config8 config = new Config8()
return config.buildConfigurations
